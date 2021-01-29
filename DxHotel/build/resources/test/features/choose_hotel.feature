#Author: Deisy Mosquera
  #Email:deisymsqr6@gmail.com

Feature: enter to page DX Hotels and choose the most economic hotel

  Background: Precondition
    Given that user enter to page

  Scenario: Carolina choose the most economic hotel
    When she choose options location, Los Angeles and start date "3/16/2021" end date "3/20/2021"
    Then she verify the total price is 450