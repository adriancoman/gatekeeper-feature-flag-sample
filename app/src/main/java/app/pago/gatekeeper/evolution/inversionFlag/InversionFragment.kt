package app.pago.gatekeeper.evolution.inversionFlag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.pago.gatekeeper.AvailableCampaigns
import app.pago.gatekeeper.Gatekeeper
import app.pago.gatekeeper.R
import app.pago.gatekeeper.evolution.inversionFlag.decisions.IpayCampaignCard
import app.pago.gatekeeper.evolution.inversionFlag.decisions.InfographicCard
import app.pago.gatekeeper.evolution.inversionFlag.decisions.VodaCampaignCard

class InversionFragment : Fragment() {

    val viewModel = InversionViewModel(
        when (Gatekeeper().getCampaign()) {
            AvailableCampaigns.VODA -> VodaCampaignCard()
            AvailableCampaigns.INFOGRAPHIC -> InfographicCard()
            AvailableCampaigns.IPAY -> IpayCampaignCard()
            AvailableCampaigns.NONE -> null
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inversion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}