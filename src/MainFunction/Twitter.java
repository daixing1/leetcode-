package MainFunction;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/4/13
 * Time: 15:18
 * Description: 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 *                  postTweet(userId, tweetId): 创建一条新的推文
 *                  getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。
 *                                       推文必须按照时间顺序由最近的开始排序。
 *                  follow(followerId, followeeId): 关注一个用户
 *                  unfollow(followerId, followeeId): 取消关注一个用户
 */
public class Twitter {
    /** Initialize your data structure here. */
    Map<Integer, List<Integer>> userFollowMap = new HashMap<>();
    Map<Integer, List<Integer>> userTweetMap = new HashMap<>();
    Map<Integer, Integer> tweetTime = new HashMap<>();
    Integer time = 0;
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweetTime.put(tweetId,time);
        if (userTweetMap.containsKey(userId)){
            userTweetMap.get(userId).add(tweetId);
        }else {
            userTweetMap.put(userId,new ArrayList<>(Arrays.asList(tweetId)));
        }
        time++;
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> followIds = userFollowMap.get(userId);
        List<Integer> tweetIds = new ArrayList<>();
        List<Integer> userTweet = userTweetMap.get(userId);
        if (userTweet!=null){
            tweetIds.addAll(userTweet);
        }
        if (followIds!=null){
            for (Integer id:followIds){
                if (userTweetMap.get(id)!=null){
                    tweetIds.addAll(userTweetMap.get(id));
                }
            }
        }
        Collections.sort(tweetIds, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (tweetTime.get(o1)>tweetTime.get(o2)){
                    return -1;
                }else {
                    return 1;
                }
            }
        });
        if (tweetIds.size()>=10){
            return tweetIds.subList(0,10).stream().distinct().collect(Collectors.toList());
        }else {
            return tweetIds.stream().distinct().collect(Collectors.toList());
        }
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (userFollowMap.containsKey(followerId)){
            userFollowMap.get(followerId).add(followeeId);
        }else {
            userFollowMap.put(followerId,new ArrayList<>(Arrays.asList(followeeId)));
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (userFollowMap.containsKey(followerId) && userFollowMap.get(followerId).contains(followeeId)){
            userFollowMap.get(followerId).remove((Object)followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1,1);
        List<Integer> newsFeed = twitter.getNewsFeed(1);
        twitter.follow(2,1);
//        twitter.postTweet(2,6);
        List<Integer> newsFeed2 = twitter.getNewsFeed(2);
        twitter.unfollow(2,1);
        List<Integer> newsFeed1 = twitter.getNewsFeed(2);
    }
}
