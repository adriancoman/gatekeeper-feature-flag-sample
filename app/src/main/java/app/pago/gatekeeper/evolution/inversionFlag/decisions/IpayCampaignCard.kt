package app.pago.gatekeeper.evolution.inversionFlag.decisions

import app.pago.gatekeeper.Constants.IPAY_IMG
import app.pago.gatekeeper.R

class IpayCampaignCard: BasicCard {
    override fun getCard() = PromoCard(
        text = R.string.ipay_title,
        imageUrl = IPAY_IMG,
        ctaText = R.string.ipay_cta
    )
}