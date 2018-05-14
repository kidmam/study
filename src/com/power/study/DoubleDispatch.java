package com.power.study;

import java.util.Arrays;
import java.util.List;

public class DoubleDispatch {

    interface Post { void postOn(SNS sns);}

    static class Text implements Post {
        public void postOn(SNS sns) {
            //System.out.println("text -> " + sns.getClass().getSimpleName());
            sns.post(this);
        }
    }

    static class Picture implements Post {
        public void postOn(SNS sns) {
            //System.out.println("Picture -> " + sns.getClass().getSimpleName());
            sns.post(this);
        }
    }


    interface SNS {
        void post(Text post);
        void post(Picture post);

    }
    static class FaceBook implements SNS {

        @Override
        public void post(Text post) {
            System.out.println("text -> facebook");
        }

        @Override
        public void post(Picture post) {
            System.out.println("picture -> facebook");

        }
    };

    static class Twitter implements SNS {

        @Override
        public void post(Text post) {
            System.out.println("text -> twitter");
        }

        @Override
        public void post(Picture post) {
            System.out.println("picture -> twitter");
        }
    }

    static class GooglePlus implements SNS {

        @Override
        public void post(Text post) {
            System.out.println("text -> googleplus");
        }

        @Override
        public void post(Picture post) {
            System.out.println("picture -> googleplus");
        }
    }

    public static void main(String[] args) {
        List<Post> posts = Arrays.asList(new Text(), new Picture());
        List<SNS> snss = Arrays.asList(new FaceBook(), new Twitter(), new GooglePlus() );

        /*for (Post post : posts) {
            for (SNS sns : snss) {
                post.postOn(sns);
            }
        }*/

        posts.forEach(p -> snss.forEach(s->p.postOn(s)));
    }
}
