package com.bobby.cloner.core.domain

abstract class BaseRequestUseCase<RequestType, ResultType> {
    protected abstract fun execute(request: RequestType): ResultType
}
