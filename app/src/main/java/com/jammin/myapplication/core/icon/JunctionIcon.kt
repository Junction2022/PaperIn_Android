package com.jammin.myapplication.core.icon

import com.jammin.myapplication.R

object JunctionIcon {

    fun Password(visible: Boolean) =
        if (visible) R.drawable.ic_password_visible else R.drawable.ic_password_invisible

    fun Good(state: Boolean) =
        if (state) R.drawable.ic_good_on else R.drawable.ic_good_off

    val Cancel = R.drawable.ic_cancel

    val File = R.drawable.ic_file_off

    val Message = R.drawable.ic_message

    val Back = R.drawable.ic_back_small

    val Plus = R.drawable.ic_plus
}
