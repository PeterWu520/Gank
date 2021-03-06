package com.qf.gank.ui.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.qf.gank.application.App

/**
 * 作者：PeterWu
 * 时间：2020/6/27
 * 描述：BaseVmActivity
 */
abstract class BaseVmActivity<VM: BaseViewModel> : BaseActivity() {

    protected open lateinit var mViewModel: VM
    private var mShareViewModel: ShareViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        // 观察LiveData的数据
        observe()
        // 因为Activity恢复后savedInstanceState不为null，
        // 重新恢复后会自动从ViewModel中的LiveData恢复数据，
        // 不需要重新初始化数据。
        if (savedInstanceState == null) {
            initData()
        }
    }

    open fun observe() {}

    open fun initData() {}

    private fun initViewModel() {
        mShareViewModel = App.instance.getAppViewModelProvider(this)?.get(ShareViewModel::class.java)
        mViewModel = ViewModelProvider(this).get(viewModelClass())
    }

    fun getShareViewModel(): ShareViewModel? {
        return mShareViewModel
    }

    protected abstract fun viewModelClass(): Class<VM>

}