
-dontpreverify
-keepattributes SourceFile,LineNumberTable

-obfuscationdictionary obf-dict.txt
-classobfuscationdictionary obf-dict.txt
-packageobfuscationdictionary obf-dict.txt

-allowaccessmodification
-overloadaggressively
-repackageclasses 'me.hd.wauxv.zygisk.obf'

-dontwarn java.lang.reflect.AnnotatedType
-dontwarn com.v7878.r8.annotations.KeepCodeAttribute
