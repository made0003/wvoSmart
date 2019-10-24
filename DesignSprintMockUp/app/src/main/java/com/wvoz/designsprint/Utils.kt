package com.wvoz.designsprint

import android.content.Context
import android.os.Vibrator

class Utils {
    public fun viberate(context: Context) {
        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        val vibrationPattern = longArrayOf(0, 500, 50, 300)
        //-1 - don't repeat
        val indexInPatternToRepeat = -1
        vibrator.vibrate(vibrationPattern, indexInPatternToRepeat)

    }
}