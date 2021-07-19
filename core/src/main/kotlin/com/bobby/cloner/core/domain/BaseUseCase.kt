package com.bobby.cloner.core.domain

abstract class BaseUseCase<RequestType, ResultType> {
    protected abstract fun execute(request: RequestType): ResultType
}
