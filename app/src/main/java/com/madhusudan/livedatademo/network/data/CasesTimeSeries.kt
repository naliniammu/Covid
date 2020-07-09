package com.madhusudan.livedatademo.network.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CasesTimeSeries {
    @SerializedName("dailyconfirmed")
    @Expose
    var dailyconfirmed: String? = null
    @SerializedName("dailydeceased")
    @Expose
    var dailydeceased: String? = null
    @SerializedName("dailyrecovered")
    @Expose
    var dailyrecovered: String? = null
    @SerializedName("date")
    @Expose
    var date: String? = null
    @SerializedName("totalconfirmed")
    @Expose
    var totalconfirmed: String? = null
    @SerializedName("totaldeceased")
    @Expose
    var totaldeceased: String? = null
    @SerializedName("totalrecovered")
    @Expose
    var totalrecovered: String? = null

}

 class Example {
    @SerializedName("cases_time_series")
    @Expose
    var casesTimeSeries: List<CasesTimeSeries>? = null
    @SerializedName("statewise")
    @Expose
    var statewise: List<Statewise>? = null
    @SerializedName("tested")
    @Expose
    var tested: List<Tested>? = null

}

 class Statewise {
    @SerializedName("active")
    @Expose
    var active: String? = null
    @SerializedName("confirmed")
    @Expose
    var confirmed: String? = null
    @SerializedName("deaths")
    @Expose
    var deaths: String? = null
    @SerializedName("deltaconfirmed")
    @Expose
    var deltaconfirmed: String? = null
    @SerializedName("deltadeaths")
    @Expose
    var deltadeaths: String? = null
    @SerializedName("deltarecovered")
    @Expose
    var deltarecovered: String? = null
    @SerializedName("lastupdatedtime")
    @Expose
    var lastupdatedtime: String? = null
    @SerializedName("migratedother")
    @Expose
    var migratedother: String? = null
    @SerializedName("recovered")
    @Expose
    var recovered: String? = null
    @SerializedName("state")
    @Expose
    var state: String? = null
    @SerializedName("statecode")
    @Expose
    var statecode: String? = null
    @SerializedName("statenotes")
    @Expose
    var statenotes: String? = null

}

 class Tested {
    @SerializedName("individualstestedperconfirmedcase")
    @Expose
    var individualstestedperconfirmedcase: String? = null
    @SerializedName("positivecasesfromsamplesreported")
    @Expose
    var positivecasesfromsamplesreported: String? = null
    @SerializedName("samplereportedtoday")
    @Expose
    var samplereportedtoday: String? = null
    @SerializedName("source")
    @Expose
    var source: String? = null
    @SerializedName("source1")
    @Expose
    var source1: String? = null
    @SerializedName("testedasof")
    @Expose
    var testedasof: String? = null
    @SerializedName("testpositivityrate")
    @Expose
    var testpositivityrate: String? = null
    @SerializedName("testsconductedbyprivatelabs")
    @Expose
    var testsconductedbyprivatelabs: String? = null
    @SerializedName("testsperconfirmedcase")
    @Expose
    var testsperconfirmedcase: String? = null
    @SerializedName("testspermillion")
    @Expose
    var testspermillion: String? = null
    @SerializedName("totalindividualstested")
    @Expose
    var totalindividualstested: String? = null
    @SerializedName("totalpositivecases")
    @Expose
    var totalpositivecases: String? = null
    @SerializedName("totalsamplestested")
    @Expose
    var totalsamplestested: String? = null
    @SerializedName("updatetimestamp")
    @Expose
    var updatetimestamp: String? = null

}