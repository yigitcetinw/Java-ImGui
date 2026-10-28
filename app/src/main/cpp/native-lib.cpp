#include <jni.h>
#include <string>
#include <android/log.h>

#define LOG_TAG "HAXBEY_IMGUI"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

extern "C" JNIEXPORT void JNICALL
Java_com_haxbey_imgui_NativeLib_startImGui(JNIEnv *env, jclass clazz) {
    LOGI("ImGui Başlatma İsteği Alındı!");
    // Buraya OpenGL/Vulkan Context entegrasyonu ve ImGui pencere çizim döngüsü eklenebilir.
}
