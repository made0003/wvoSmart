package com.wvoz.designsprint

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.support.wearable.activity.WearableActivity
import androidx.databinding.DataBindingUtil
import com.wvoz.designsprint.databinding.ActivityDossierBinding

class DossierActivity : WearableActivity() {
    private var mBinding: ActivityDossierBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_dossier)
        mBinding?.recording = false


        mBinding?.dossier?.setOnClickListener {
            displaySpeechRecognizer()
        }


        // Enables Always-on
        setAmbientEnabled()
    }

    private val SPEECH_REQUEST_CODE = 0


    // Create an intent that can start the Speech Recognizer activity
    private fun displaySpeechRecognizer() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        )
        // Start the activity, the intent will be populated with the speech text
        startActivityForResult(intent, SPEECH_REQUEST_CODE)
    }

    // This callback is invoked when the Speech Recognizer returns.
    // This is where you process the intent and extract the speech text from the intent.
    override fun onActivityResult(
        requestCode: Int, resultCode: Int,
        data: Intent
    ) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            val results = data.getStringArrayListExtra(
                RecognizerIntent.EXTRA_RESULTS
            )
            val spokenText = results[0]
            val i = Intent(this, LogConfirmActivity::class.java)
            i.putExtra("text", spokenText)
            startActivity(i)
            finish()

            // Do something with spokenText
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
