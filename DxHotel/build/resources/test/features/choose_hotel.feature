#Author: Deisy Mosquera
  #Email:deisymsqr6@gmail.com

Feature: enter to page DX Hotels and choose the most economic hotel

  Background: Precondition
    Given that user enter to page

  Scenario: Carolina choose the most economic hotel
    When she choose options location, Paris and start date "4/08/2021" end date "4/12/2021"
    Then she verify the total price is 550