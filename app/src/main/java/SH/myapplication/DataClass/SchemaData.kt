package SH.myapplication.DataClass

import net.glxn.qrgen.core.scheme.Schema
import net.glxn.qrgen.core.scheme.SchemeUtil


class SchemaData : Schema {
    var morph: String? = null
        private set
    var parent: String? = null
        private set
    var dob: String? = null
        private set
    var sex: String? = null

    constructor() : super() {}
    constructor(name: String?) {
        this.morph = name
    }

    fun setMorph(Morph: String?): SchemaData {
        this.morph = Morph
        return this
    }

    fun setParent(Parent: String?): SchemaData {
        this.parent = Parent
        return this
    }

    fun setDob(Dob: String?): SchemaData {
        this.dob = Dob
        return this
    }

    fun setSex(Sex: String?): SchemaData {
        this.sex = Sex
        return this
    }

    override fun parseSchema(code: String): Schema {
        require(!(code == null || !code.startsWith(BEGIN_DATA))) { "this is not a valid VCARD code: $code" }
        val parameters = SchemeUtil.getParameters(code)
        if (parameters.containsKey(MORPH)) {
            setMorph(parameters[MORPH])
        }
        if (parameters.containsKey(PARENT)) {
            setParent(parameters[PARENT])
        }
        if (parameters.containsKey(DOB)) {
            setDob(parameters[DOB])
        }
        if (parameters.containsKey(SEX)) {
            setSex(parameters[SEX])
        }
        return this
    }

    override fun generateString(): String {
        val sb = StringBuilder()
        sb.append(BEGIN_DATA).append(SchemeUtil.LINE_FEED)
        sb.append("VERSION:1.0").append(SchemeUtil.LINE_FEED)
        if (morph != null) {
            sb.append(MORPH).append(" : ").append(morph)
        }
        if (parent != null) {
            sb.append(SchemeUtil.LINE_FEED).append(PARENT).append(" : ")
                .append(parent)
        }
        if (dob != null) {
            sb.append(SchemeUtil.LINE_FEED).append(DOB).append(" : ")
                .append(dob)
        }
        if (sex != null) {
            sb.append(SchemeUtil.LINE_FEED).append(SEX).append(" : ")
                .append(sex)
        }
        sb.append(SchemeUtil.LINE_FEED).append("END:DATA")
        return sb.toString()
    }

    /**
     * Returns the textual representation of this vcard of the form
     *
     *
     * BEGIN:VCARD N:John Doe ORG:Company TITLE:Title TEL:1234 URL:www.example.org
     * EMAIL:john.doe@example.org ADR:Street END:VCARD
     *
     */
    override fun toString(): String {
        return generateString()
    }

    companion object {
        private const val BEGIN_DATA = "BEGIN:DATA"
        private const val MORPH = "MORPH"
        private const val PARENT = "PARENT"
        private const val DOB = "DOB"
        private const val SEX = "SEX"
        fun parse(code: String?): SchemaData {
            val schemadata = SchemaData()
            if (code != null) {
                schemadata.parseSchema(code)
            }
            return schemadata
        }
    }
}
