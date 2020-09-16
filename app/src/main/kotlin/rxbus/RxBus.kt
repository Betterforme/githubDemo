package github.demo.client.rxbus

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.subjects.PublishSubject

/**
 *
 *说明：
 *@since: 2020-09-16
 *@author: shijie
 *
 */
object RxBus {
    private val bus: PublishSubject<Any?> = PublishSubject.create()

    private val disposableList = mutableListOf<Disposable>()
    fun send(event: Any?) {
        bus.onNext(event)
    }

    fun get(block: (Any?) -> Unit) {
        val disposable = bus.observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                block.invoke(it)
            }
        disposableList.add(disposable)
    }

    fun removeAll() {
        disposableList.forEach {
            it.dispose()
        }
    }
}