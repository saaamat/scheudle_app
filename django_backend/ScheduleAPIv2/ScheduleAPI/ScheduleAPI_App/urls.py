from django.urls import path
from . import views

urlpatterns = {
    path('', views.index),
    path('descriptions/', views.descriptionAPI),
    path('events/', views.eventAPI),
    path('names/', views.nameAPI),
    path('profiles/', views.profileAPI),
    path('profiles_events/', views.profileeventAPI)
}