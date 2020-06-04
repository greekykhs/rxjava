package com.rxjava;

import rx.Observable;
import rx.Subscriber;

public class RxJavaDemoJust {
	public static void main(String[] args) {
		Observable<Integer> justObservable = Observable.just(1,2,3,null);
		Subscriber<Integer> intSubscriber = new Subscriber<Integer>() {
			public void onCompleted() {
				System.out.println("onCompleted()");
			}

			public void onError(Throwable e) {
				System.out.println("onErro()");
			}

			public void onNext(Integer i) {
				System.out.println("onNext(): " + i);
			}
		};
		justObservable.subscribe(intSubscriber);
	}
}
