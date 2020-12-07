package com.jiahaoliuliu.unittestwithmockk

class Ext {
    fun Obj.extensionFunc() = value + 5
}

fun Obj.topLevelExtension() = value + 1000