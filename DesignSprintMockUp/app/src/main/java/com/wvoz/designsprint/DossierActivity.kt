package com.wvoz.designsprint

import android.content.Intent
import android.os.Bundle
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
            if (mBinding?.recording == true) {
                val i = Intent(this, LogConfirmActivity::class.java)
                startActivity(i)
                finish()
            } else {
                mBinding?.recording = true
            }
        }


        // Enables Always-on
        setAmbientEnabled()
    }
}
