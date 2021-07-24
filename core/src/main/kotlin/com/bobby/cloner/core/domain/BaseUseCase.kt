package com.bobby.cloner.core.domain

abstract class BaseUseCase<ResultType> {
    protected abstract suspend fun execute(): ResultType
}
