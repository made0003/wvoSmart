package com.wvoz.designsprint

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MedicatieAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val mFragments = arrayOfNulls<MedicatieFragment>(4)

    init {

        mFragments[0] = MedicatieFragment.newInstance(
            R.string.medicijn_1,
            R.string.medicijn_beschrijving_1
        )
        mFragments[1] = MedicatieFragment.newInstance(
            R.string.medicijn_2,
            R.string.medicijn_beschrijving_2
        )
        mFragments[2] = MedicatieFragment.newInstance(
            R.string.medicijn_3,
            R.string.medicijn_beschrijving_3
        )
        mFragments[3] = MedicatieFragment.newInstance(finalScreen = true)
    }

    override fun getItem(position: Int): Fragment {
        return mFragments[position] as Fragment
    }

    override fun getCount(): Int {
        return mFragments.size
    }

}
