package com.broad.habbit.domain.entity

import androidx.annotation.DrawableRes

interface MenuViewBehavior {
    fun setStatus(primary: Boolean) : MenuViewBehavior
    fun setName(name: String) : MenuViewBehavior
    fun setIcon(@DrawableRes ic: Int) : MenuViewBehavior
    fun build(): MenuViewField
}


data class MenuViewField(
    var text: String,
    @DrawableRes var ic: Int,
    var status: Boolean,
    var height: Float,
) {
    class Builder: MenuViewBehavior {
        private var height: Float = 0f
        private var isPrimaryBorder: Boolean = false
        private var cardName: String = ""
        @DrawableRes
        private var cardIcon: Int = 0

        override fun setStatus(primary: Boolean): MenuViewBehavior {
            if (primary) {
                this.height = 150f
                this.isPrimaryBorder = true
            }  else {
                this.height = 100f
                this.isPrimaryBorder = false
            }
            return this
        }

        override fun setName(name: String): MenuViewBehavior {
            this.cardName = name
            return this
        }

        override fun setIcon(ic: Int): MenuViewBehavior {
            this.cardIcon = ic
            return this
        }

        override fun build(): MenuViewField {
            return MenuViewField(
                text = this.cardName,
                ic = this.cardIcon,
                status = this.isPrimaryBorder,
                height = this.height
            )
        }

    }
}
