package com.example.daggerscopes.di.common

import androidx.fragment.app.Fragment

object ComponentFinder {

    /**
     * Traverses parent fragments, activity and application in search of given class.
     * Throws IllegalArgument exception if it fails to find one.
     * Must be called after onAttach().
     */
    inline fun <reified T : Any> find(fragment: Fragment): T {
        return find(T::class.java, fragment)
    }

    @JvmStatic
    fun <T : Any> find(clazz: Class<T>, fragment: Fragment): T {
        var parentFragment: Fragment? = fragment
        while (true) {
            parentFragment = parentFragment?.parentFragment ?: break
            if (parentFragment instanceOf clazz) {
                return parentFragment as T
            }
        }
        val activity = fragment.activity
        if (activity instanceOf clazz) {
            return activity as T
        }
        val application = activity?.application
        if (application instanceOf clazz) {
            return application as T
        }
        throw IllegalArgumentException(
            String.format("No ${clazz.simpleName} was found for %s", fragment.javaClass.canonicalName)
        )
    }

    private infix fun Any?.instanceOf(clazz: Class<*>) = clazz.isInstance(this)
}