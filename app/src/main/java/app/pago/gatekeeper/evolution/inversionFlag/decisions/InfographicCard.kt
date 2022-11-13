package app.pago.gatekeeper.evolution.inversionFlag.decisions

import app.pago.gatekeeper.Constants.INFOG_IMG
import app.pago.gatekeeper.R

class InfographicCard: BasicCard {
    override fun getCard() = PromoCard(
        text = R.string.infographic_title,
        imageUrl = INFOG_IMG,
        ctaText = R.string.infographic_cta
    )
}