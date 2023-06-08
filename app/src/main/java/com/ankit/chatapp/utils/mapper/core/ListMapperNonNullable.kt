package com.ankit.chatapp.utils.mapper.core

interface ListMapperNonNullable<I, O> :
    Mapper<List<I>?, List<O>>