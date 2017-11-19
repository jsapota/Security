/**
 * Created by Jakub on 09.11.2017.
 */
import {Mongo} from  'meteor/mongo'
import SimpleSchema from 'simpl-schema';

SimpleSchema.extendOptions(['autoform']);
SimpleSchema.debug = true;


Transfers = new Mongo.Collection('transfers');


const TransfersSchema = new SimpleSchema({
  userName: {
    type: String,
    autoValue: function () {
      return this.userId
    },
    optional: true
  },
  name: {
    type: String
  },
  number: {
    type: Number
  },
  amount: {
    type: Number
  },
  createdAt: {
    type: Date,
    autoValue: function() {
      return new Date();
    }
  }
});

Transfers.attachSchema(TransfersSchema);

export default Transfers;