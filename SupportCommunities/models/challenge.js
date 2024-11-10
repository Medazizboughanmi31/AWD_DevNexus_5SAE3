// models/challenge.js
const mongoose = require('mongoose');

const challengeSchema = new mongoose.Schema({
    name: {
        type: String,
        required: true,
    },
    description: {
        type: String,
        required: true,
    },
    goal: {
        type: String,
        required: true,
    },
    startDate: { type: Date, default: Date.now },
    endDate: { type: Date },
    participants: [{
        type: mongoose.Schema.Types.ObjectId,
        ref: 'User',
    }],
    createdBy: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'User',
    },
    status: {
        type: String,
        enum: ['Active', 'Completed', 'Expired'],
        default: 'Active',
    },
});

const Challenge = mongoose.model('Challenge', challengeSchema);

module.exports = Challenge;
