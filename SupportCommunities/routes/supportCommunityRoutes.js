const express = require('express');
const SupportCommunityController = require('../controller/supportCommunityController');
const router = express.Router();

// Define routes for support communities
router.post('/', SupportCommunityController.createCommunity);
router.get('/', SupportCommunityController.getAllCommunities);
router.post('/:id/join', SupportCommunityController.joinCommunity);

module.exports = router;
