# Notes

* Started by creating a Discount interface that would be implemented by the various discounts
* Each discount would implement interface with its own applyDiscount function
* DiscountAggregator would aggregate all discounts for a list of items 
* After roughly an hour the first discount is working fine
* With more time we could add the other discounts quite easily based on the existing architecture

* Challenges
  * Select the right architecture for the problem
  * Implementing the TwoForOneDiscount logic