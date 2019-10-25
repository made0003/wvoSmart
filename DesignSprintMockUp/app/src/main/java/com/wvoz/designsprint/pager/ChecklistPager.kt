package com.wvoz.designsprint.pager

import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import com.wvoz.designsprint.R
import com.wvoz.designsprint.adapter.ChecklistAdapter
import com.wvoz.designsprint.databinding.PagerLayoutBinding

class ChecklistPager : FragmentActivity() {

    private var mBinding: PagerLayoutBinding? = null

    private var mSecondIndicator: ImageView? = null
    private var mFirstIndicator: ImageView? = null
    private var mThirdIndicator: ImageView? = null
    private var mFourthIndicator: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.pager_layout)
        mBinding?.pager?.adapter =
            ChecklistAdapter(supportFragmentManager)


        mFirstIndicator = findViewById(R.id.indicator_0)
        mSecondIndicator = findViewById(R.id.indicator_1)
        mThirdIndicator = findViewById(R.id.indicator_2)
        mFourthIndicator = findViewById(R.id.indicator_3)

        mBinding?.pager?.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(i: Int, v: Float, i2: Int) {}

            override fun onPageSelected(i: Int) {
                setIndicator(i)
            }

            override fun onPageScrollStateChanged(i: Int) {}
        })
    }

    /**
     * Sets the page indicator for the ViewPager.
     */
    private fun setIndicator(i: Int) {
        when (i) {
            0 -> {
                mFirstIndicator?.setImageResource(R.drawable.full_10)
                mSecondIndicator?.setImageResource(R.drawable.empty_10)
                mThirdIndicator?.setImageResource(R.drawable.empty_10)
                mFourthIndicator?.setImageResource(R.drawable.empty_10)
            }
            1 -> {
                mFirstIndicator?.setImageResource(R.drawable.empty_10)
                mSecondIndicator?.setImageResource(R.drawable.full_10)
                mThirdIndicator?.setImageResource(R.drawable.empty_10)
                mFourthIndicator?.setImageResource(R.drawable.empty_10)
            }
            2 -> {
                mFirstIndicator?.setImageResource(R.drawable.empty_10)
                mSecondIndicator?.setImageResource(R.drawable.empty_10)
                mThirdIndicator?.setImageResource(R.drawable.full_10)
                mFourthIndicator?.setImageResource(R.drawable.empty_10)
            }
            3 -> {
                mFirstIndicator?.setImageResource(R.drawable.empty_10)
                mSecondIndicator?.setImageResource(R.drawable.empty_10)
                mThirdIndicator?.setImageResource(R.drawable.empty_10)
                mFourthIndicator?.setImageResource(R.drawable.full_10)
            }
        }
    }

}
