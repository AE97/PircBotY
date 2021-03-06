package net.ae97.pircboty.snapshot;

import java.util.List;
import java.util.Set;
import net.ae97.pircboty.Channel;
import net.ae97.pircboty.PircBotY;
import net.ae97.pircboty.User;
import net.ae97.pircboty.UserChannelDao;
import net.ae97.pircboty.UserLevel;
import net.ae97.pircboty.Utils;

public class ChannelSnapshot extends Channel {

    private UserChannelDaoSnapshot<? extends PircBotY> dao;
    private final Channel generatedFrom;
    private final String mode;

    public ChannelSnapshot(Channel channel, String mode) {
        super(channel.getBot(), null, channel.getName());
        this.generatedFrom = channel;
        this.mode = mode;
        super.setCreateTimestamp(channel.getCreateTimestamp());
        super.setTopic(channel.getTopic());
        super.setTopicSetter(channel.getTopicSetter());
        super.setTopicTimestamp(channel.getTopicTimestamp());
        super.setChannelKey(channel.getChannelKey());
        super.setChannelLimit(channel.getChannelLimit());
        super.setChannelPrivate(channel.isChannelPrivate());
        super.setInviteOnly(channel.isInviteOnly());
        super.setModerated(channel.isModerated());
        super.setNoExternalMessages(channel.isNoExternalMessages());
        super.setSecret(channel.isSecret());
        super.setTopicProtection(channel.hasTopicProtection());
    }

    public UserChannelDaoSnapshot<? extends PircBotY> getSnapshotDao() {
        return dao;
    }

    @Override
    public UserChannelDao<PircBotY, User, Channel> getDao() {
        throw new UnsupportedOperationException("Cannot get Dao for a snapshot channel");
    }

    @Override
    public Set<UserLevel> getUserLevels(User user) {
        return getSnapshotDao().getLevels(this, user instanceof UserSnapshot ? (UserSnapshot) user : user.createSnapshot());
    }

    @Override
    public Set<User> getNormalUsers() {
        return Utils.<User>castSet(getSnapshotDao().getNormalUsers(this), User.class);
    }

    @Override
    public Set<User> getOps() {
        return Utils.<User>castSet(getSnapshotDao().getUsers(this, UserLevel.OP), User.class);
    }

    @Override
    public Set<User> getVoices() {
        return Utils.<User>castSet(getSnapshotDao().getUsers(this, UserLevel.VOICE), User.class);
    }

    @Override
    public Set<User> getOwners() {
        return Utils.<User>castSet(getSnapshotDao().getUsers(this, UserLevel.OWNER), User.class);
    }

    @Override
    public Set<User> getHalfOps() {
        return Utils.<User>castSet(getSnapshotDao().getUsers(this, UserLevel.HALFOP), User.class);
    }

    @Override
    public Set<User> getSuperOps() {
        return Utils.<User>castSet(getSnapshotDao().getUsers(this, UserLevel.SUPEROP), User.class);
    }

    @Override
    public Set<User> getUsers() {
        return Utils.<User>castSet(getSnapshotDao().getUsers(this), User.class);
    }

    @Override
    public ChannelSnapshot createSnapshot() {
        throw new UnsupportedOperationException("Attempting to generate channel snapshot from a snapshot");
    }

    @Override
    public void setTopic(String topic) {
        throw new UnsupportedOperationException("Cannot change settings on snapshot");
    }

    @Override
    public void setTopicTimestamp(long topicTimestamp) {
        throw new UnsupportedOperationException("Cannot change settings on snapshot");
    }

    @Override
    public void setCreateTimestamp(long createTimestamp) {
        throw new UnsupportedOperationException("Cannot change settings on snapshot");
    }

    @Override
    public void setTopicSetter(String topicSetter) {
        throw new UnsupportedOperationException("Cannot change settings on snapshot");
    }

    @Override
    public void setModerated(boolean moderated) {
        throw new UnsupportedOperationException("Cannot change settings on snapshot");
    }

    @Override
    public void setNoExternalMessages(boolean noExternalMessages) {
        throw new UnsupportedOperationException("Cannot change settings on snapshot");
    }

    @Override
    public void setInviteOnly(boolean inviteOnly) {
        throw new UnsupportedOperationException("Cannot change settings on snapshot");
    }

    @Override
    public void setSecret(boolean secret) {
        throw new UnsupportedOperationException("Cannot change settings on snapshot");
    }

    @Override
    public void setChannelPrivate(boolean channelPrivate) {
        throw new UnsupportedOperationException("Cannot change settings on snapshot");
    }

    @Override
    public void setTopicProtection(boolean topicProtection) {
        throw new UnsupportedOperationException("Cannot change settings on snapshot");
    }

    @Override
    public void setChannelLimit(int channelLimit) {
        throw new UnsupportedOperationException("Cannot change settings on snapshot");
    }

    @Override
    public void setChannelKey(String channelKey) {
        throw new UnsupportedOperationException("Cannot change settings on snapshot");
    }

    @Override
    protected void setMode(String mode, List<String> modeParsed) {
        throw new UnsupportedOperationException("Cannot change settings on snapshot");
    }

    public Channel getGeneratedFrom() {
        return generatedFrom;
    }

    public void setDao(UserChannelDaoSnapshot<? extends PircBotY> dao) {
        this.dao = dao;
    }
}
