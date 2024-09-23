package com.example.daytodayexpenses

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.RecognitionListener
import android.speech.SpeechRecognizer
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class VoiceRecognitionActivity : AppCompatActivity(), RecognitionListener {

    private lateinit var speechRecognizer: SpeechRecognizer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_voice_recognition)

        // Check for RECORD_AUDIO permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.RECORD_AUDIO), 1)
            }
        }

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this)
        speechRecognizer.setRecognitionListener(this)

        val startButton = findViewById<Button>(R.id.startVoiceButton)
        val stopButton = findViewById<Button>(R.id.stopVoiceButton)

        stopButton.isEnabled = false  // Disable the stop button initially

        startButton.setOnClickListener {
            startListening()
            stopButton.isEnabled = true  // Enable the stop button after starting recognition
        }

        stopButton.setOnClickListener {
            stopListening()
            stopButton.isEnabled = false  // Disable the stop button again after stopping recognition
        }
    }

    private fun startListening() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something")
        speechRecognizer.startListening(intent)
    }

    private fun stopListening() {
        try {
            speechRecognizer.stopListening()
        } catch (e: Exception) {
            Log.e("VoiceRecognitionAct", "Error stopping recognition: ${e.message}")
        }
    }

    override fun onResults(results: Bundle?) {
        val spokenTexts = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
        spokenTexts?.let {
            val command = it[0].lowercase()
            if (command.contains("open expenses")) {
                navigateToExpenses()
            }
        }
    }

    private fun navigateToExpenses() {
        val intent = Intent(this, ExpenseListActivity::class.java)
        startActivity(intent)
    }

    override fun onError(error: Int) {
        val errorMessage = when (error) {
            SpeechRecognizer.ERROR_AUDIO -> "Audio recording error"
            SpeechRecognizer.ERROR_CLIENT -> "Client-side error"
            SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS -> "Insufficient permissions"
            SpeechRecognizer.ERROR_NETWORK -> "Network error"
            SpeechRecognizer.ERROR_NETWORK_TIMEOUT -> "Network timeout"
            SpeechRecognizer.ERROR_NO_MATCH -> "No match found"
            SpeechRecognizer.ERROR_RECOGNIZER_BUSY -> "RecognitionService busy"
            SpeechRecognizer.ERROR_SERVER -> "Server error"
            SpeechRecognizer.ERROR_SPEECH_TIMEOUT -> "No speech input"
            else -> "Unknown error"
        }
        Log.e("VoiceRecognitionAct", "Speech recognizer error: $errorMessage (Code: $error)")
        Toast.makeText(this, "Speech recognizer error: $errorMessage", Toast.LENGTH_SHORT).show()
    }

    override fun onReadyForSpeech(params: Bundle?) {}
    override fun onBeginningOfSpeech() {}
    override fun onRmsChanged(rmsdB: Float) {}
    override fun onBufferReceived(buffer: ByteArray?) {}
    override fun onEndOfSpeech() {}
    override fun onPartialResults(partialResults: Bundle?) {}
    override fun onEvent(eventType: Int, params: Bundle?) {}

    override fun onDestroy() {
        super.onDestroy()
        speechRecognizer.destroy()
    }
}
