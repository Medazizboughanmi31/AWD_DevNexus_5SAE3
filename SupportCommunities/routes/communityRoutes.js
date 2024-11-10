// routes/communityRoutes.js
const express = require('express');
const SupportCommunity = require('../models/supportCommunity');
const Post = require('../models/post');
const Challenge = require('../models/challenge');

const router = express.Router();

// Create a new community
router.post('/', async (req, res) => {
    try {
        const newCommunity = new SupportCommunity(req.body);
        await newCommunity.save();
        res.status(201).json(newCommunity);
    } catch (error) {
        res.status(400).json({ message: 'Error creating community', error });
    }
});

// Get all communities
router.get('/', async (req, res) => {
    try {
        const communities = await SupportCommunity.find().populate('posts').populate('challenges');
        res.status(200).json(communities);
    } catch (error) {
        res.status(500).json({ message: 'Error retrieving communities', error });
    }
});

// Add a post to a community
router.post('/:communityId/posts', async (req, res) => {
    try {
        const post = new Post(req.body);
        await post.save();

        const community = await SupportCommunity.findById(req.params.communityId);
        community.posts.push(post._id);
        await community.save();

        res.status(201).json(post);
    } catch (error) {
        res.status(400).json({ message: 'Error creating post', error });
    }
});

// Create a challenge
router.post('/:communityId/challenges', async (req, res) => {
    try {
        const challenge = new Challenge(req.body);
        await challenge.save();

        const community = await SupportCommunity.findById(req.params.communityId);
        community.challenges.push(challenge._id);
        await community.save();

        res.status(201).json(challenge);
    } catch (error) {
        res.status(400).json({ message: 'Error creating challenge', error });
    }
});

module.exports = router;
