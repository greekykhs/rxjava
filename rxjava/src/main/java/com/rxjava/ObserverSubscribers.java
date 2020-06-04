package com.rxjava;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

public class ObserverSubscribers {

	public static void test() {
		Subscriber<String> mySubscriber = new Subscriber<String>() {
			public void onNext(String s) {
				System.out.println(s);
			}

			public void onCompleted() {
			}

			public void onError(Throwable e) {
			}
		};

		Observer<String> myObserver = new Observer<String>() {
			public void onNext(String s) {
				System.out.println("MyObserver onNext(): " + s);
			}

			public void onCompleted() {
				System.out.println("Observer complete");
			}

			public void onError(Throwable e) {
			}
		};
	}
	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		
		
		Observable<String> myObservable 
			= Observable.create(new Observable.OnSubscribe<String>() {
	            public void call(Subscriber<? super String> subscriber) {
	                //Code to pass the data to the subscribers and observers goes here.
	            }
			});
	}

}
