package zyf.interfaces;

import javax.annotation.security.PermitAll;

import zyf.interfaces.impl.ServiceImpl;
import zyf.provider.WwwServiceProvider;

import com.google.inject.ImplementedBy;
import com.google.inject.ProvidedBy;

@ImplementedBy(ServiceImpl.class)
@ProvidedBy(WwwServiceProvider.class)
public interface Service {
	void execute();
}
