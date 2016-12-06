LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_CERTIFICATE := platform

LOCAL_PROGUARD_ENABLED := disabled

LOCAL_SRC_FILES := \
        $(call all-java-files-under, src) \
        src/com/android/majipeng/IMyService.aidl

LOCAL_PACKAGE_NAME := binder_java

include $(BUILD_PACKAGE)


# additionally, build tests in sub-folders in a separate .apk
include $(call all-makefiles-under,$(LOCAL_PATH))
