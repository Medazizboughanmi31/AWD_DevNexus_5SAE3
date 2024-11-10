const mongoose = require('mongoose');

const supportCommunitySchema = new mongoose.Schema({
    name: {
        type: String,
        required: true,
    },
    type: {
        type: String,
        enum: ['Weight Loss', 'Bodybuilding', 'Yoga for Beginners'],
        required: true,
    },
    description: {
        type: String,
        required: true,
    },
    posts: [{
        type: mongoose.Schema.Types.ObjectId,
        ref: 'Post',
    }],
    challenges: [{
        type: mongoose.Schema.Types.ObjectId,
        ref: 'Challenge',
    }],
    members: [{
        type: mongoose.Schema.Types.ObjectId,
        ref: 'User', // Reference to users that are part of the community
    }],
    createdAt: { type: Date, default: Date.now },
});

// Make sure you're exporting the model
module.exports = mongoose.model('SupportCommunity', supportCommunitySchema);
