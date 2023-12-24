from rest_framework import serializers
from .models import Descriptions, Events, Names, Profiles, ProfilesEvents

class DescriptionSerializer(serializers.ModelSerializer):
    class Meta:
        model = Descriptions
        fields = ('id', 'name', 'description', 'index')

class EventSerializer(serializers.ModelSerializer):
    class Meta:
        model = Events
        fields = ('id', 'start_time', 'end_time', 'subject_name', 'location', 'instructors', 'event_type', 'subject_name_short')

class NameSerializer(serializers.ModelSerializer):
    class Meta:
        model = Names
        fields = ('id', 'name')

class ProfileSerializer(serializers.ModelSerializer):
    class Meta:
        model = Profiles
        fields = ('id', 'name', 'index')

class ProfileEventSerializer(serializers.ModelSerializer):
    class Meta:
        model = ProfilesEvents
        fields = ('id', 'profile', 'event')