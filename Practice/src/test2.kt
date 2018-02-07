class KotlinClass{
    companion object{
        var normal: Int = 1
        const val constValue: Int = 2
        @JvmField var jvmFiledValue: Int = 3
    }
}

public static void main(String[] args){
    int normal value = KotlinClass.Companion.getNormal();
    int constValue = KotlinClass.constValue;
    int jvmFieldValue = KotlinClass.jvmFiledValue;

    KotlinClass.Companion.setNormarl(2);
    KotlinClass.constValue = 3;  // error
    KotlinClass.jvmFiledValue = 5;
}