package io.bratexsoft.specialtycofeecode.domain.base

/**
 * Created by mateuszbratkowski on 04/01/2018.
 */
interface UseCase<T> {
    fun execute(): T
}