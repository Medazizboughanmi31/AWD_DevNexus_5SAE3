const SupportCommunityService = require('../services/supportCommunityService');

class SupportCommunityController {
    static async createCommunity(req, res) {
        try {
            const community = await SupportCommunityService.createCommunity(req.body);
            res.status(201).json(community);
        } catch (err) {
            res.status(500).json({ message: err.message });
        }
    }

    static async getAllCommunities(req, res) {
        try {
            const communities = await SupportCommunityService.getAllCommunities();
            res.status(200).json(communities);
        } catch (err) {
            res.status(500).json({ message: err.message });
        }
    }

    static async joinCommunity(req, res) {
        try {
            const community = await SupportCommunityService.joinCommunity(req.params.id, req.body.userId);
            res.status(200).json(community);
        } catch (err) {
            res.status(500).json({ message: err.message });
        }
    }
}

module.exports = SupportCommunityController;
