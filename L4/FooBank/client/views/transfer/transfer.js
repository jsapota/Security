Template.transfer.onCreated(function(){
  this.stageOne = new ReactiveVar(true);
  this.stageTwo = new ReactiveVar(true);
  this.recName = new ReactiveVar("");
  this.recNumber = new ReactiveVar("");
  this.recAmount = new ReactiveVar("");
});

Template.transfer.helpers({
  stageOne: () => {
    return Template.instance().stageOne.get();
  },
  stageTwo: () => {
    return Template.instance().stageTwo.get();
  },
  recName: () => {
    return Template.instance().recName.get();
  },
  recNumber: () => {
    return Template.instance().recNumber.get();
  },
  recAmount: () => {
    return Template.instance().recAmount.get();
  },
});

Template.transfer.events({
  'click #confirmButton': () => {
    let recName = "" + document.getElementById("recName").value;
    let recNumber = document.getElementById("recNumber").value;
    let amount = document.getElementById("amount").value;
    let amountPartial = document.getElementById("amountPartial").value || "00";
    Template.instance().recName.set(recName);
    Template.instance().recNumber.set(recNumber);
    Template.instance().recAmount.set("" + amount + "." + amountPartial);
    if(recName.length > 0 && recNumber > 0 && amount > 0)
      Template.instance().stageOne.set(false);
  },
  'click #confirmSendButton': () => {
    let recName =   document.getElementById("nameField").value;
    let recNumber = document.getElementById("numberField").value;
    let recAmount = document.getElementById("amountField").value;
    document.getElementById("nameField").value = "";
    document.getElementById("numberField").value = "";
    document.getElementById("amountField").value = "";
    Transfers.insert({"name": recName, "number": recNumber, "amount": recAmount});
    Template.instance().stageTwo.set(false);
  },
  'click #back': () => {
    Template.instance().stageOne.set(true);
  }
});