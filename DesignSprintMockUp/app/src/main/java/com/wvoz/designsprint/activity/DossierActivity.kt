package com.wvoz.designsprint.activity

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.speech.RecognizerIntent
import android.support.wearable.activity.WearableActivity
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.wvoz.designsprint.R
import com.wvoz.designsprint.databinding.ActivityDossierBinding


class DossierActivity : WearableActivity() {
    private var mBinding: ActivityDossierBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_dossier
        )
        mBinding?.recording = false


        if (isWiFiConnected(this)) {
            mBinding?.dossier?.setOnClickListener {
                displaySpeechRecognizer()
            }
        } else {
            Toast.makeText(this, "Geen internet!", Toast.LENGTH_SHORT).show()
            val i = Intent(this, LogConfirmActivity::class.java)
            startActivity(i)
            finish()
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
            i.putExtra("text", results[0])
            startActivity(i)
            finish()
        }

    }


    fun isWiFiConnected(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork
            val capabilities = connectivityManager.getNetworkCapabilities(network)
            capabilities != null && capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
        } else {
            connectivityManager.activeNetworkInfo.type == ConnectivityManager.TYPE_WIFI
        }
    }
}
