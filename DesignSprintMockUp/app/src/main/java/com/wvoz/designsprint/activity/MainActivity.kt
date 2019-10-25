package com.wvoz.designsprint.activity

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.view.View
import androidx.databinding.DataBindingUtil
import com.wvoz.designsprint.R
import com.wvoz.designsprint.Utils
import com.wvoz.designsprint.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : WearableActivity() {

    private var mBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        setTime()

        mBinding?.mainContent?.setOnClickListener { confirm() }

        // Enables Always-on
        setAmbientEnabled()
    }

    private fun setTime(){
        mBinding?.timeText?.text = SimpleDateFormat("HH:mm", Locale.GERMANY).format(Date())
    }

    private fun confirm() {
        Utils().viberate(this)
        mBinding?.checkbox?.visibility = View.VISIBLE
                mBinding?.checkbox?.animate()
                    ?.setDuration(500)
                    ?.alpha(1f)
                    ?.withEndAction {
                        val i = Intent(this, NachtDossierActivity::class.java)
                                            startActivity(i)
                    finish()
                    }
                    ?.start()
    }

}
