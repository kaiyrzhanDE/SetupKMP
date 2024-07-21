package di

import org.koin.core.module.Module

fun commonModules(): List<Module> = listOf(
    utilsModule,
    networkModule,
    tokenModule,
)