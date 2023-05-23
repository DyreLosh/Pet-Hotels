package com.dyrelosh.pethotels.presentation.ui.user

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dyrelosh.pethotels.manager.BottomNavManager

abstract class UserBaseFragment : Fragment(){
    open val showBottomNavigationView: Boolean
        get() = (parentFragment as? UserBaseFragment)?.showBottomNavigationView ?: false

    private var bottomNavigationViewManager: BottomNavManager? = null
    protected fun setBottomNavigationViewVisibility(isVisible: Boolean) {
        bottomNavigationViewManager?.setBottomNavVisibility(isVisible)
    }

    override fun onAttach(context: Context) {
        if (context is BottomNavManager) {
            bottomNavigationViewManager = context
        }
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomNavigationViewManager?.setBottomNavVisibility(showBottomNavigationView)
    }
}