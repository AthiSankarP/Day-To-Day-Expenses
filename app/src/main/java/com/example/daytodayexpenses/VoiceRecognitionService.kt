package com.example.daytodayexpenses

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.RecognitionListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class VoiceRecognitionActivityService : AppCompatActivity(), RecognitionListener {

    private lateinit var speechRecognizer: SpeechRecognizer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_voice_recognition)

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this)
        speechRecognizer.setRecognitionListener(this)

        startListening()
    }

    private fun startListening() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something")
        speechRecognizer.startListening(intent)
    }

    override fun onResults(results: Bundle?) {
        val spokenTexts = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
        spokenTexts?.let {
            val command = it[0].toLowerCase()
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
        Toast.makeText(this, "Error occurred: $error", Toast.LENGTH_SHORT).show()
    }

    override fun onReadyForSpeech(params: Bundle?) {}
    override fun onBeginningOfSpeech() {}
    override fun onRmsChanged(rmsdB: Float) {}
    override fun onBufferReceived(buffer: ByteArray?) {}
    override fun onEndOfSpeech() {}
    override fun onPartialResults(partialResults: Bundle?) {}
    override fun onEvent(eventType: Int, params: Bundle?) {}
}
