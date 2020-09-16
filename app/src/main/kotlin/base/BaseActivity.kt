package base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import github.demo.client.Util.GenericUtil
import kotlin.reflect.KClass

/**
 *
 *说明：activity基类
 *@since: 2020-09-16
 *@author: shijie
 *
 */
abstract class BaseActivity<VM : ViewModel> : AppCompatActivity() {

    lateinit var viewModel: VM
        private set

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        setContentView(getLayoutId())
        flowOfGetData()
        flowOfSetupData()
        flowOfInitUi()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)
            .get(requireNotNull(GenericUtil.getClassType(this, ViewModel::class) as KClass<VM>).java)
    }

    abstract fun getLayoutId(): Int

    /***
     * 获取数据
     */
    open fun flowOfGetData() {}

    /**
     * 数据安装部分
     */
    open fun flowOfSetupData() {}

    open fun flowOfInitUi(){}
}