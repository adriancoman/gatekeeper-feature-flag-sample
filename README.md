# Feature flags - Increase the Frequency, Stability and Confidence in Your Releases

This is the code showed during my presentation about Feature Flags.

[<img src="https://user-images.githubusercontent.com/4348190/201528860-d1b7bbdf-53ac-4f77-9b63-89d60de079b7.png" width="250"/>](voda_campaign.png)
[<img src="https://user-images.githubusercontent.com/4348190/201528857-5ea79656-2e72-4999-b11c-beda2bae04a9.png" width="250"/>](card_campaign.png)
[<img src="https://user-images.githubusercontent.com/4348190/201528859-52b9fea2-4df6-45ea-b241-7aac122dba80.png" width="250"/>](infographic_campaign.png)

## Archaic Feature Flags
The most "archaic" way of using a feature flag, comment or uncomment the code to get the expected result.
```Kotlin
fun getCardToDisplay() {
    // var isVodaCampaign = true // uncomment to test
    val isVodaCampaign = false
    val cardToDisplay = if (isVodaCampaign) {
        PromoCard(
            text = R.string.voda_title,
            imageUrl = VODA_IMG,
            ctaText = R.string.voda_cta
        )
    } else {
        null
    }
}
```

## Basic Feature Flag
A basic example of a feature flag, where we keep the string and the remote config in the ViewModel.
```Kotlin
fun getCardToDisplay() {
    val cardToDisplay = if (remoteCampaignFlag == "voda_campaign_2021") {
        PromoCard(
            text = R.string.voda_title,
            imageUrl = VODA_IMG,
            ctaText = R.string.voda_cta
        )
    } else {
        null
    }
}
```


## Feature Flag Extracted From VM
Extracted the logic from the ViewModel to a separate class that handles the remote value and the possible scenarios. The construction the card is still done in the ViewModel.
```Kotlin
fun getCardToDisplay() {
    val cardToDisplay = when (gatekeeper.getCampaign()) {
        AvailableCampaigns.VODA -> {
            PromoCard(
                text = R.string.voda_title,
                imageUrl = VODA_IMG,
                ctaText = R.string.voda_cta
            )
        }
        AvailableCampaigns.INFOGRAPHIC -> {
            PromoCard(
                text = R.string.infographic_title,
                imageUrl = INFOG_IMG,
                ctaText = R.string.infographic_cta
            )
        }
        else -> {
            null
        }
    }
}
```

## Feature Flags Using Sockets & Flow
Example using Flow while getting the config from a remote host using sockets so you have real time enabling or disabling of feature flags. 
```Kotlin
fun getCardToDisplay() {
    viewModelScope.launch {
        gatekeeper.getCampaignFlow().collect { campaign ->
            getCampaignCard(campaign)?.let { cardToDisplay ->
                ...
            }
        }
    }
}
```

## Inverson of Control
Using Inversion of Control so that you keep the ViewModel as clean as possible. Gatekeeper decides what to show.
```Kotlin
fun getCardToDisplay() {
    displayedCard?.getCard()?.let { cardToDisplay ->
        viewModelScope.launch {
            _activeCampaign.emit(cardToDisplay)
        }
    }
}
```
