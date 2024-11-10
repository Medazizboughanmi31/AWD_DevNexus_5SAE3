const SupportCommunity = require('../models/supportCommunity'); // Import model

class SupportCommunityService {
    // Create a community
    static async createCommunity(communityData) {
        const { name, type, description } = communityData;
        try {
            const newCommunity = new SupportCommunity({
                name,
                type,
                description,
                createdAt: new Date(),
            });
            const community = await newCommunity.save();
            return community;
        } catch (err) {
            throw new Error('Error creating community: ' + err.message);
        }
    }

    // Get all communities
    static async getAllCommunities() {
        try {
            const communities = await SupportCommunity.find();
            return communities;
        } catch (err) {
            throw new Error('Error retrieving communities: ' + err.message);
        }
    }

    // Join a community
    static async joinCommunity(communityId, userId) {
        try {
            const community = await SupportCommunity.findById(communityId);

            if (!community) {
                throw new Error('Community not found');
            }

            if (community.members.includes(userId)) {
                throw new Error('User is already a member');
            }

            community.members.push(userId);
            await community.save();

            return community;
        } catch (err) {
            throw new Error('Error joining community: ' + err.message);
        }
    }
}

module.exports = SupportCommunityService;
