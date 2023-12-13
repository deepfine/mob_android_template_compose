package com.deepfine.data.mapper

import com.deepfine.data.model.Fact
import com.deepfine.network.model.FactApiModel
import com.deepfine.network.model.FactsApiModel

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

internal fun FactApiModel.toModel(): Fact = Fact(fact, length)

internal fun FactsApiModel.toModel(): List<Fact> = facts.map(FactApiModel::toModel)
