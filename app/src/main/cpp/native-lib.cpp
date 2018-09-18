#include <jni.h>
#include <string>


extern "C"
JNIEXPORT jstring JNICALL
Java_com_amal_viewqwest_utility_Constant_baseUrl(JNIEnv *env, jclass /* this */) {
    std::string hello = "http://sd2-hiring.herokuapp.com/api/";
    return env->NewStringUTF(hello.c_str());
}